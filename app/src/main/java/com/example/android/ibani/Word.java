package com.example.android.ibani;

/**
 * Created by kuthumi on 8/16/2018.
 * {@link Word} represents a vocabulary word or phrase that the user wants to learn
 * It contains a default translation and an Ibani translation for that word or phrase
 */

public class Word {
    /**
     * Ibani translation for the word
     */
    private String mIbaniTranslation;

    /**
     * default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * image resource ID for word
     */
    private int mImageResourceId;

    /**
     * audio resource ID for word
     */
    private int mAudioResourceId;

    /**
     * class variable
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Creates a new Word object
     *
     * @param defaultTranslation is a word or phrase in a language that the user is already
     *                           family with (English in this case)
     * @param ibaniTranslation   is the word or phrase in the Ibani Language
     * @param imageResourceId    is a static integer that serves as the ID of the image
     * @param audioResourceId    is a static integer that serves as the ID of the audio file
     */

    public Word(String defaultTranslation, String ibaniTranslation, int imageResourceId,
                int audioResourceId) {
        mIbaniTranslation = ibaniTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Creates a new Word object
     *
     * @param defaultTranslation is a word or phrase in a language that the user is already
     *                           family with (English in this case)
     * @param ibaniTranslation   is the word or phrase in the Ibani Language
     * @param audioResourceId    is a static integer that serves as the ID of the audio file
     */
    public Word(String defaultTranslation, String ibaniTranslation, int audioResourceId) {
        this(defaultTranslation, ibaniTranslation, NO_IMAGE_PROVIDED, audioResourceId);
    }

    /**
     * get default translation of the word
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * get Ibani translation of the word
     */
    public String getIbaniTranslation() {
        return mIbaniTranslation;
    }

    /**
     * get image resource ID for the word
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * get audio resource ID for the word
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * @return true or false depending on whether the word has an image or not
     */
    public boolean hasImage() {
        return (mImageResourceId != NO_IMAGE_PROVIDED);
    }
}
