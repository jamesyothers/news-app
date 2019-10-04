/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.articlereport;

/**
 * An {@link Article} object contains information related to a single article.
 */
public class Article {

    /** Magnitude of the article */
    private String mSectionName;

    /** Location of the article */
    private String mLocation;

    /** Time of the article */
    private String mDateTimePublication;

    /** Website URL of the article */
    private String mUrl;

    /**
     * Constructs a new {@link Article} object.
     */
    public Article(String sectionName, String location, String dateTimePublication, String url) {
        mSectionName = sectionName;
        mLocation = location;
        mDateTimePublication = dateTimePublication;
        mUrl = url;
    }

    /**
     * Returns the section of the article.
     */
    public String getSectionName() {
        return mSectionName;
    }

    /**
     * Returns the location of the article.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Returns the dateTime of the article.
     */
    public String getDateTimePublication() {
        return mDateTimePublication;
    }

    /**
     * Returns the website URL to find more information about the article.
     */
    public String getUrl() {
        return mUrl;
    }
}
