package com.lcodecore.twinklingrefreshlayout;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.StrictMode;

/**
 * ContentProvider that runs very early in app startup. We use it to set a non-fatal
 * StrictMode policy (penaltyLog) before the system/ROM components run and potentially
 * trigger DiskReadViolation with penaltyDeath.
 */
public class StrictModeProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        // Set permissive reporting-only StrictMode policies as early as possible.
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

