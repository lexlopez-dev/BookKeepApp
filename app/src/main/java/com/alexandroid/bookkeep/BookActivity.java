package com.alexandroid.bookkeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtViewTitle, txtViewAuthor, txtPages, txtDescription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFavorites;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDescription = "The year is 1984 and the city is Tokyo.\n" +
//                "\n" +
//                "A young woman named Aomame follows a taxi driver’s enigmatic suggestion and begins to notice puzzling discrepancies in the world around her. She has entered, she realizes, a parallel existence, which she calls 1Q84 “Q is for ‘question mark.’ A world that bears a question.” Meanwhile, an aspiring writer named Tengo takes on a suspect ghostwriting project. He becomes so wrapped up with the work and its unusual author that, soon, his previously placid life begins to come unraveled.\n" +
//                "\n" +
//                "As Aomame’s and Tengo’s narratives converge over the course of this single year, we learn of the profound and tangled connections that bind them ever closer: a beautiful, dyslexic teenage girl with a unique vision; a mysterious religious cult that instigated a shoot-out with the metropolitan police; a reclusive, wealthy dowager who runs a shelter for abused women; a hideously ugly private investigator; a mild-mannered yet ruthlessly efficient bodyguard; and a peculiarly insistent television-fee collector.\n" +
//                "\n" +
//                "A love story, a mystery, a fantasy, a novel of self-discovery, a dystopia to rival George Orwell’s 1Q84 is Haruki Murakami’s most ambitious undertaking yet: an instant best seller in his native Japan, and a tremendous feat of imagination from one of our most revered contemporary writers.";
//
//
//
//
//        Book book = new Book(1, "1Q84", "Haruki Murakami", 1350, "https://images-na.ssl-images-amazon.com/images/I/71hhB1Rwk4L.jpg", "A work of maddening brilliance", longDescription);

        Intent intent = getIntent();
        if(intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if(bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if(incomingBook != null) {
                    setData(incomingBook);
                }
            }
        }

    }

    private void setData(Book book) {
        txtViewTitle.setText(book.getName());
        txtViewAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDescription());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {
        txtViewTitle = findViewById(R.id.txtViewTitle);
        txtViewAuthor = findViewById(R.id.txtViewAuthor);
        txtPages = findViewById(R.id.txtViewPages);
        txtDescription = findViewById(R.id.txtViewDescription);

        btnAddToWantToRead = findViewById(R.id.btnAddToWant);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);

        bookImage = findViewById(R.id.imgBookCover);
    }
}