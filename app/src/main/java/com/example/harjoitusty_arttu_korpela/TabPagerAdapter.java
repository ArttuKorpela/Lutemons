/*
----------------------------------------------------------------------------------------------------
This is the adapter that sets the fragments for the "LutemonsTabActicity".
----------------------------------------------------------------------------------------------------
*/
package com.example.harjoitusty_arttu_korpela;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.harjoitusty_arttu_korpela.fragmentsLutemons.CreateNewLutemonFragment;
import com.example.harjoitusty_arttu_korpela.fragmentsLutemons.FallenLutemonsFragment;
import com.example.harjoitusty_arttu_korpela.fragmentsLutemons.ListLutemonFragment;

public class TabPagerAdapter extends FragmentStateAdapter  {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ListLutemonFragment();
            case 1:
                return new CreateNewLutemonFragment();
            case 2:
                return new FallenLutemonsFragment();
            default:
                return new ListLutemonFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
