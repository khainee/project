package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
abstract class IndexBasedArrayIterator<T> implements Iterator<T> {
    private boolean mCanRemove;
    private int mIndex;
    private int mSize;

    protected abstract T elementAt(int i);

    protected abstract void removeAt(int i);

    IndexBasedArrayIterator(int startingSize) {
        this.mSize = startingSize;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.mIndex < this.mSize;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T res = elementAt(this.mIndex);
        this.mIndex++;
        this.mCanRemove = true;
        return res;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.mCanRemove) {
            throw new IllegalStateException();
        }
        int i = this.mIndex - 1;
        this.mIndex = i;
        removeAt(i);
        this.mSize--;
        this.mCanRemove = false;
    }
}
