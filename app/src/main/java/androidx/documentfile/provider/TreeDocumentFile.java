package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes46.dex */
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String str, String str2) {
        TreeDocumentFile treeDocumentFile;
        Uri uriCreateFile = createFile(this.mContext, this.mUri, str, str2);
        if (uriCreateFile != null) {
            treeDocumentFile = treeDocumentFile;
            TreeDocumentFile treeDocumentFile2 = new TreeDocumentFile(this, this.mContext, uriCreateFile);
        } else {
            treeDocumentFile = null;
        }
        return treeDocumentFile;
    }

    @Nullable
    private static Uri createFile(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createDirectory(String str) {
        TreeDocumentFile treeDocumentFile;
        Uri uriCreateFile = createFile(this.mContext, this.mUri, "vnd.android.document/directory", str);
        if (uriCreateFile != null) {
            treeDocumentFile = treeDocumentFile;
            TreeDocumentFile treeDocumentFile2 = new TreeDocumentFile(this, this.mContext, uriCreateFile);
        } else {
            treeDocumentFile = null;
        }
        return treeDocumentFile;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() throws Exception {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(this.mUri, DocumentsContract.getDocumentId(this.mUri));
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, cursorQuery.getString(0)));
                }
                closeQuietly(cursorQuery);
            } catch (Exception e) {
                Log.w("DocumentFile", "Failed query: " + e);
                closeQuietly(cursorQuery);
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                documentFileArr[i] = new TreeDocumentFile(this, this.mContext, uriArr[i]);
            }
            return documentFileArr;
        } catch (Throwable th) {
            closeQuietly(cursorQuery);
            throw th;
        }
    }

    private static void closeQuietly(@Nullable AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) throws FileNotFoundException {
        try {
            Uri uriRenameDocument = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, str);
            if (uriRenameDocument != null) {
                this.mUri = uriRenameDocument;
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
