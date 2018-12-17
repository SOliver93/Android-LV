package com.example.arcus.laboratorijskevjezbe_android.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.arcus.laboratorijskevjezbe_android.Listeners.PersonalInfoListener;
import com.example.arcus.laboratorijskevjezbe_android.R;

public class PersonalInfoFragment extends Fragment {

    private static final String EXTRA_IMAGE_ID = "EXTRA_IMAGE_ID";
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    public static PersonalInfoFragment newInstance(){

        Bundle args = new Bundle();

        PersonalInfoFragment fragment = new PersonalInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PersonalInfoListener personalInfoListener;
    EditText etName;
    EditText etSurname;
    EditText etBirthDate;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_info_layout,container,false);
        etName = view.findViewById(R.id.editIme);
        etSurname = view.findViewById(R.id.editPrezime);
        etBirthDate = view.findViewById(R.id.editRodenje);

        imageView = view.findViewById(R.id.imgAvatar);
        imageView.setOnClickListener(onCameraButtonClickListener);

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(personalInfoListener!=null){
                    personalInfoListener.setName(etName.getText().toString());
                }
            }
        });

        etSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                personalInfoListener.setLastName(etSurname.getText().toString());
            }
        });

        etBirthDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                personalInfoListener.setBirthDate(etBirthDate.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        personalInfoListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            setupImageView(imageBitmap);
        }
    }

    private void setupImageView(int drawableId){
        imageView.setImageResource(drawableId);
    }

    private void setupImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

    View.OnClickListener onCameraButtonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(takePictureIntent.resolveActivity(getActivity().getPackageManager())!= null){
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    };
}