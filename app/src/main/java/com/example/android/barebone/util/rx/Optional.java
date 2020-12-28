package com.example.android.barebone.util.rx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.NoSuchElementException;

/**
 * A wrapper around nullable objects because RxJava 2.x does not allow null types.
 * This can be used as a safe wrapper for streams that would otherwise have a null value.
 */
public final class Optional<T> {

    @Nullable
    private final T value;

    public Optional(@Nullable T value) {
        this.value = value;
    }

    /**
     * @return The value if present. Throws a [NoSuchElementException] if null
     */
    @NonNull
    public T get() {
        if (value == null) {
            throw new NoSuchElementException("Optional is null");
        }
        return value;
    }

    /**
     * @return {@code true} if the underlying value is null
     */
    public boolean isNull() {
        return value == null;
    }

    /**
     * @return The value even if it is null. Use with caution.
     */
    @Nullable
    public T getValueOrNull() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Optional)) {
            return false;
        }

        Optional<?> other = (Optional<?>) obj;
        return (value == other.value) || (value != null && value.equals(other.value));
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
