package ao.now.nk.nk_now_app.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ao.now.nk.nk_now_app.R;
import ao.now.nk.nk_now_app.fragments.FilmFragment;
import ao.now.nk.nk_now_app.fragments.ProfileFragment;
import ao.now.nk.nk_now_app.fragments.SearchFragment;
import ao.now.nk.nk_now_app.fragments.SettingsFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_film);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
                int id = item.getItemId();
                if (id == R.id.navigation_film) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, FilmFragment.newInstance(), FilmFragment.TAG)
                            .commit();
                    return true;
                } else if (id == R.id.navigation_profile) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, ProfileFragment.newInstance(), ProfileFragment.TAG)
                            .commit();
                    return true;
                } else if (id == R.id.navigation_search) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, SearchFragment.newInstance(), SearchFragment.TAG)
                            .commit();
                    return true;
                } else if (id == R.id.navigation_settings) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, SettingsFragment.newInstance(), SettingsFragment.TAG)
                            .commit();
                    return true;
                }
                return false;
            };

}
