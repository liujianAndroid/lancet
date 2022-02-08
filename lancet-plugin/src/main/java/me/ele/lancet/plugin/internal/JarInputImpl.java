package me.ele.lancet.plugin.internal;

import com.android.annotations.NonNull;
import com.android.build.api.transform.JarInput;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Status;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;

import java.io.File;
import java.util.Set;

public class JarInputImpl extends QualifiedContentImpl implements JarInput {

    @NonNull
    private final Status status;

    public JarInputImpl(
            @NonNull String name,
            @NonNull File file,
            @NonNull Status status,
            @NonNull Set<ContentType> contentTypes,
            @NonNull Set<? super Scope> scopes) {
        super(name, file, contentTypes, scopes);
        this.status = status;
    }

    public JarInputImpl(
            @NonNull QualifiedContent qualifiedContent,
            @NonNull Status status) {
        super(qualifiedContent);
        this.status = status;
    }

    @NonNull
    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", getName())
                .add("file", getFile())
                .add("contentTypes", Joiner.on(',').join(getContentTypes()))
                .add("scopes", Joiner.on(',').join(getScopes()))
                .add("status", status)
                .toString();
    }
}
