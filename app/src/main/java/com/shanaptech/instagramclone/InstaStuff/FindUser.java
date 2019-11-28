package com.shanaptech.instagramclone.InstaStuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shanaptech.instagramclone.R;

public class FindUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);
    }
}
/*

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private CircleImageView circleImageView;
    private EditText editText;
    private ArrayList<UserObject> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);


        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleAdapter(getApplication(), Data_set());
        recyclerView.setAdapter(adapter);

        InputMethodManager imm = (InputMethodManager) getApplication().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);


        circleImageView = findViewById(R.id.circle_image);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                Search();
            }
        });

    }

    private void clear() {
        int size = this.arrayList.size();
        this.arrayList.clear();
        adapter.notifyItemChanged(0, size);
    }


    private ArrayList<UserObject> Data_set() {
        Search();
        return arrayList;
    }


    private void Search() {

        DatabaseReference dref = FirebaseDatabase.getInstance().getReference().child("users");

        Query query = dref.orderByChild("email").startAt(editText.getText().toString().trim()).endAt(editText.getText().toString().trim() + " \uf8ff");

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String email = "";

                String uid = dataSnapshot.getRef().getKey();

                if (dataSnapshot.child("email").getValue() != null) {
                    email = dataSnapshot.child("email").getValue().toString();

                }
                if (!email.equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
                    UserObject obj = new UserObject(email, uid);
                    arrayList.add(obj);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
 */
// show captured image
/*
String uid ;
    Bitmap bitmap ;
    ImageView img ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturedimg);

        img = findViewById(R.id.Image_Capture);

    try {
        bitmap = BitmapFactory.decodeStream(getApplication().openFileInput("Imgs"));
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    img.setImageBitmap(bitmap);
        uid = FirebaseAuth.getInstance().getUid();
        ImageButton save = findViewById(R.id.save_photo);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save_story();
            }
        });
        ImageButton search = findViewById(R.id.search_friends);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Capturedimg.this , FindUser.class));
            }
        });


    }

    private void Save_story() {
        final DatabaseReference dref = FirebaseDatabase.getInstance().getReference()
                .child("users").child("uid").child("Story");

        final String key = dref.push().getKey();


        StorageReference filepath = FirebaseStorage
         .getInstance().getReference().child("photos").child(key);

        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG , 20, boas);

        byte [] dataUpload = boas.toByteArray();

        UploadTask uploadTask = filepath.putBytes(dataUpload);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Capturedimg.this, " Error Happen", Toast.LENGTH_SHORT).show();
            finish();
            }
        });

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Uri uri = taskSnapshot.getUploadSessionUri();

                Long start = System.currentTimeMillis();
                Long current = start * (24 * 60 * 60 * 1000);

                Map<String , Object> map = new HashMap<>();

                map.put("imguri" , uri);
                map.put("startTime",start);
                map.put("currentTime",current);

                dref.child(key).setValue(map);
            }
        });



    }
 */

// display image
/*

        imageView = findViewById(R.id.display_user_img);

        Bundle b = getIntent().getExtras();
        user_id = b.getString("user_id");

        Story_Show();

    }

    ArrayList<String> uriList = new ArrayList<>();
    private void Story_Show() {

            DatabaseReference dref = FirebaseDatabase.getInstance().getReference()
                    .child("users").child(user_id);


            dref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String imguri = "";
                    long start = 0;
                    long current = 0;

                    for (DataSnapshot snap:
                            dataSnapshot.child("Story").getChildren()) {
                        if (snap.child("startTime").getValue() != null) {
                            start = Long.parseLong(snap.child("startTime").getValue().toString());
                        }
                        if (snap.child("currentTime").getValue() != null) {
                            current = Long.parseLong(snap.child("currentTime").getValue().toString());
                        }
                        if (snap.child("imguri").getValue() != null) {
                            imguri = snap.child("imguri").getValue().toString();
                        }

                        if(current >= start  && current<= start){
                            uriList.add(imguri);
                            //  check if we find imgs or not
                            if(!started)
                            {
                                started = true ;
                                Display();
                            }

                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        private int imgcount =0;

    private void Display() {
        Glide.with(getApplication()).load(uriList.get(imgcount)).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_Data();
            }
        });
        final Handler h = new Handler();
        final int delay = 5000;
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                change_Data();
                h.postDelayed(this , delay);
            }
        },delay);
    }

    private void change_Data() {
       if (imgcount == uriList.size() -1)
        {
            finish();
            return;

        }
       imgcount++;
        Glide.with(getApplication()).load(uriList.get(imgcount)).into(imageView);
    }
 */