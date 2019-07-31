package com.dieznote.ks_internship.Fragments;


import android.app.LoaderManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dieznote.ks_internship.Listeners.ButtonSelectListener;
import com.dieznote.ks_internship.Listeners.OnTaskRecyclerItemClickListener;
import com.dieznote.ks_internship.MainActivity;
import com.dieznote.ks_internship.adapters.ResponseRecyclerAdapter;
import com.dieznote.ks_internship.api.ApiCallback;
import com.dieznote.ks_internship.api.RestClient;
import com.dieznote.ks_internship.models.NetResponse;
import com.dieznote.ks_internship.models.Person;
import com.dieznote.ks_internship.R;
import com.dieznote.ks_internship.models.ResponseErrorItem;
import com.dieznote.ks_internship.utils.ApplicationSettingsManager;
import com.dieznote.ks_internship.utils.Consts;
import com.dieznote.ks_internship.utils.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Response;


public class FirstFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    ArrayList<Person> persons;
    RecyclerView recyclerView;

    private EditText searchQueryInput;
    private AppCompatButton goButton;
    private ProgressBar progressBar;

    private ResponseRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Database database;
    private static final String TAG = MainActivity.class.getSimpleName();


    private ButtonSelectListener buttonSelectListener;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, " OnCreate Fragment ");
        super.onCreate(savedInstanceState);

        database = new Database(getContext());
        database.open();

        getActivity().getLoaderManager().initLoader(Consts.LOADER_ID, null, this);


    }

    @Override
    public void onAttach(Context context) {
        Log.e(TAG, " onAttach Fragment ");
        super.onAttach(context);
        try {
            buttonSelectListener = (ButtonSelectListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "A!");
        }
    }

    @Override
    public void onStart() {
        Log.e(TAG, " onStart Fragment ");
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, " onCreateView Fragment ");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        searchQueryInput = v.findViewById(R.id.et_username_input);
        goButton = v.findViewById(R.id.btn_go);
        progressBar = v.findViewById(R.id.pb_progress);

        recyclerView = (RecyclerView) v.findViewById(R.id.rv_repos_recycler);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ResponseRecyclerAdapter(database.getAllData(), getContext(), new OnTaskRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position, int id) {
                //openInfo(id);
                Toast t = Toast.makeText(getContext(),"Нажатие на "+position,Toast.LENGTH_SHORT);
                t.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(searchQueryInput.getText().toString())) {
                    searchQueryInput.requestFocus();
                } else {
                    doRequest(searchQueryInput.getText().toString());
                }
            }
        });

        return v;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyCursorLoader(getContext(), database);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
    private void openInfo(Uri url) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), "No application can handle this request." + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    private void doRequest(String query) {
            searchReposByName(query);
    }
    private void searchReposByName(String name) {
        showProgressBlock();
        RestClient.getInstance().getService().searchRepos(name).enqueue(new ApiCallback<NetResponse>() {

            @Override
            public void success(Response<NetResponse> response) {
                updateList(response.body());
                hideProgressBlock();
            }

            @Override
            public void failure(ResponseErrorItem gitRepoError) {
                handleError(gitRepoError);
                hideProgressBlock();
            }
        });
    }
    private void updateList(NetResponse itemsToUpdate) {
        database.addApiData(itemsToUpdate);
        Objects.requireNonNull(getActivity()).getLoaderManager().getLoader(Consts.LOADER_ID).forceLoad();
    }

    private void handleError(ResponseErrorItem errorItem) {
        if (TextUtils.isEmpty(errorItem.getDocumentation_url())) {
            makeErrorToast(errorItem.getMessage());
        } else {
            makeErrorToast(errorItem.getMessage() + errorItem.getDocumentation_url());
        }
    }
    private void makeErrorToast(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
    private void showProgressBlock() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }
    private void hideProgressBlock() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }
    /**
     * Subclass of {@link android.content.CursorLoader} which provides loader associated
     * with application database's implementation.
     */
    static class MyCursorLoader extends CursorLoader {

        Database db;

        public MyCursorLoader(Context context, Database db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            return db.getAllData();
        }

    }
}
