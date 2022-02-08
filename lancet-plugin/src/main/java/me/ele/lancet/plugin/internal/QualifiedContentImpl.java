package me.ele.lancet.plugin.internal;

import com.android.build.api.transform.QualifiedContent;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import java.io.File;
import java.io.Serializable;
import java.util.Set;

class QualifiedContentImpl implements QualifiedContent, Serializable {

    private final String name;
    private final File file;
    private final Set<ContentType> contentTypes;
    private final Set<? super Scope> scopes;

    protected QualifiedContentImpl(
            String name,
            File file,
            Set<ContentType> contentTypes,
            Set<? super Scope> scopes) {
        this.name = name;
        this.file = file;
        this.contentTypes = ImmutableSet.copyOf(contentTypes);
        this.scopes = ImmutableSet.copyOf(scopes);
    }

    protected QualifiedContentImpl(QualifiedContent qualifiedContent) {
        this.name = qualifiedContent.getName();
        this.file = qualifiedContent.getFile();
        this.contentTypes = qualifiedContent.getContentTypes();
        this.scopes = qualifiedContent.getScopes();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<ContentType> getContentTypes() {
        return contentTypes;
    }

    @Override
    public Set<? super Scope> getScopes() {
        return scopes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("file", file)
                .add("contentTypes", contentTypes)
                .add("scopes", scopes)
                .toString();
    }
}
