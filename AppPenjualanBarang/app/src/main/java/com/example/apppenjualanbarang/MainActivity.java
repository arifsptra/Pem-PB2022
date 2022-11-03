package com.example.apppenjualanbarang;

import static com.example.apppenjualanbarang.Constants.EXTRA_ALATKESEHATAN;
import static com.example.apppenjualanbarang.Constants.EXTRA_POSITION;
import static com.example.apppenjualanbarang.Constants.RESULT_ADD;
import static com.example.apppenjualanbarang.Constants.RESULT_DELETE;
import static com.example.apppenjualanbarang.Constants.RESULT_UPDATE;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apppenjualanbarang.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements LoadAlatKesehatanCallback {
    ActivityMainBinding binding;

    AlatKesehatanAdapter adapter;

    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getData() != null) {
                    if (result.getResultCode() == RESULT_ADD) {
                        AlatKesehatan alatKesehatan = result.getData().getParcelableExtra(EXTRA_ALATKESEHATAN);

                        adapter.addItem(alatKesehatan);
                        binding.rvList.smoothScrollToPosition(adapter.getItemCount() - 1);

                        showSnackbarMessage("Item berhasil ditambahkan!");
                    } else if (result.getResultCode() == RESULT_UPDATE) {
                        AlatKesehatan alatKesehatan = result.getData().getParcelableExtra(EXTRA_ALATKESEHATAN);
                        int position = result.getData().getIntExtra(EXTRA_POSITION, 0);

                        adapter.updateItem(position, alatKesehatan);
                        binding.rvList.smoothScrollToPosition(position);

                        showSnackbarMessage("Item berhasil diupdate!");
                    } else if (result.getResultCode() == RESULT_DELETE) {
                        int position = result.getData().getIntExtra(EXTRA_POSITION, 0);

                        adapter.removeItem(position);

                        showSnackbarMessage("Item berhasil dihapus!");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new AlatKesehatanAdapter(new OnItemClickCallback() {
            @Override
            public void onAlatKesehatanClicked(AlatKesehatan selectedAlatKesehatan, int position) {
                Intent iDetail = new Intent(MainActivity.this, DetailActivity.class);
                iDetail.putParcelableArrayListExtra(EXTRA_ALATKESEHATAN, selectedAlatKesehatan);
                iDetail.putExtra(EXTRA_POSITION, position);
                resultLauncher.launch(iDetail);
            }
        });

        binding.rvList.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvList.setAdapter(adapter);

        binding.btnAddAlatKesehatan.setOnClickListener(v -> {
            Intent iAdd = new Intent(MainActivity.this, AddActivity.class);
            resultLauncher.launch(iAdd);
        });

        new LoadAlatKesehatanAsync(getApplicationContext(), this).execute();
    }

    private void showSnackbarMessage(String message) {
        Snackbar.make(binding.rvList, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void preExecute() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void postExecute(ArrayList<AlatKesehatan> alatKesehatan) {
        binding.progressBar.setVisibility(View.GONE);
        if (alatKesehatan.size() > 0) {
            adapter.setAlatKesehatanList(alatKesehatan);
        } else {
            adapter.setAlatKesehatanList(new ArrayList<AlatKesehatan>());
            showSnackbarMessage("Tidak ada data saat ini!");
        }
    }

    public static class LoadAlatKesehatanAsync {

        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadAlatKesehatanCallback> weakCallback;

        private LoadAlatKesehatanAsync(Context context, LoadAlatKesehatanCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            weakCallback.get().preExecute();
            executor.execute(() -> {
                Context context = weakContext.get();

                AlatKesehatanHelper alatKesehatanHelper = AlatKesehatanHelper.getInstance(context);
                alatKesehatanHelper.open();
                Cursor dataCursor = alatKesehatanHelper.queryAll();
                ArrayList<AlatKesehatan> alatKesehatanList = MappingHelper.mapCursorToArrayList(dataCursor);
                alatKesehatanHelper.close();

                handler.post(() -> weakCallback.get().postExecute(alatKesehatanList));
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.list_mode) {
            binding.rvList.setAdapter(adapter);
            adapter.toggleViewMode(false);
            binding.rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } else if (item.getItemId() == R.id.grid_mode) {
            binding.rvList.setAdapter(adapter);
            adapter.toggleViewMode(true);
            binding.rvList.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (item.getItemId() == R.id.menu_laporan) {
            Intent intent = new Intent(this, MainActivityLaporan.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}