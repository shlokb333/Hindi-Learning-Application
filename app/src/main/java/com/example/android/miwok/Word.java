package com.example.android.miwok;

public class Word {
    /*Default translation of the word*/
    private String mDefaultTranslation;
    /*Hindi translation of the word*/
    private String mhindiTranslation;
    /*Resource ID of image*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /*Audio resource for ech word*/
    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String hindiTranslation, int audioResource) {
        this.mDefaultTranslation = defaultTranslation;
        this.mhindiTranslation = hindiTranslation;
        this.mAudioResourceId = audioResource;
    }

    public Word(String mDefaultTranslation, String mhindiTranslation, int mImageResourceId, int audioResource) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mhindiTranslation = mhindiTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = audioResource;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getHindiTranslation() {
        return mhindiTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
