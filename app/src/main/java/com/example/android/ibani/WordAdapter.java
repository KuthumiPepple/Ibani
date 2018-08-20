package com.example.android.ibani;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kuthumi on 8/20/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    // background color for text views of each fragment
    private int mColor_ID;

    /**
     * creates a WordAdapter object
     *
     * @param context   The current context. Used to inflate the list_item layout file
     * @param wordItems A list of items used in populating the ListView. Each item consists of :
     *                  a word or phrase in Ibani language;
     *                  the default language equivalent of that word or phrase;
     *                  a sound clip; and
     *                  an optional image.
     * @param color     Background color for text views in each list item
     */
    public WordAdapter(Activity context, ArrayList<Word> wordItems, int color) {
        super(context, 0, wordItems);
        mColor_ID = color;
    }

    /**
     * Provides view for Adapter View(ListView, GridView etc)
     *
     * @param position    The current position of the data - in a list of data - that is
     *                    to be displayed in the listItemView (local var in getView()).
     * @param convertView The recycled view to populate
     * @param parent      The parent ViewGroup that is used for inflating the listItemView
     * @return The View for the position in the AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // check if the existing view is being reused. Otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // get the {@link Word} object located at this position
        Word currentWord = getItem(position);

        // find the text view in list_item with the ID ibani_text_view
        TextView ibaniTextView = listItemView.findViewById(R.id.ibani_text_view);
        // get the Ibani translation text from currentWord and set the text on the ibaniTextView
        ibaniTextView.setText(currentWord.getIbaniTranslation());

        // find the text view in list_item with the ID default_text_view
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        // get the default translation text and set it on the defaultTextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // get the image in list_item with the ID image
        ImageView imageView = listItemView.findViewById(R.id.image);

        // check if currentWord has an image
        if (currentWord.hasImage()) {
            // get the image resource ID from currentWord and set the image on imageView
            imageView.setImageResource(currentWord.getImageResourceId());
            // because views are recycled, we must ensure that the imageView is visible,
            // in case it was previously invisible
            imageView.setVisibility(View.VISIBLE);
        } else
            // hide imageView
            imageView.setVisibility(View.GONE);

        // set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // resolve color
        int color = ContextCompat.getColor(getContext(), mColor_ID);
        // set the background color of the textContainer View
        textContainer.setBackgroundColor(color);
        return listItemView;

    }
}
