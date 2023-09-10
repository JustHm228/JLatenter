package com.github.justhm228.jlatenter.base;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;

import java.lang.*;

import static java.util.Objects.*;

@AvailableSince(value = "0.1-build.2")
@NonExtendable()
@NonBlocking()
public final class Library {

    @AvailableSince(value = "0.1-build.2")
    @Internal()
    @NonBlocking()
    @Contract(value = " -> fail", pure = true)
    private Library() throws Error, UnsupportedOperationException {

        super();
        throw new UnsupportedOperationException("You can't instantiate an instance of this type (" + getClass().getTypeName() + ") with a constructor!");
    }

    @AvailableSince(value = "0.1-build.2")
    @NonExtendable()
    @NonBlocking()
    @Contract(value = " -> _", pure = true)
    @Override()
    public @NotNull(exception = NullPointerException.class) String toString() throws Error {

        return super.toString();
    }

    @AvailableSince(value = "0.1-build.2")
    @NonExtendable()
    @NonBlocking()
    @Contract(value = "null -> false; !null -> _", pure = true)
    @Override()
    public boolean equals(@Nullable(value = "Can be null anytime") final Object another) throws Error {

        return another instanceof Library;
    }

    @AvailableSince(value = "0.1-build.2")
    @NonExtendable()
    @NonBlocking()
    @Contract(value = " -> _", pure = true)
    @Override()
    public int hashCode() throws Error {

        return hash(getClass());
    }

    @AvailableSince(value = "0.1-build.2")
    @Internal()
    @NonExtendable()
    @NonBlocking()
    @Contract(value = " -> fail", pure = true)
    @Deprecated(since = "0.1-build.2")
    @Override()
    protected Library clone() throws Error, CloneNotSupportedException {

        throw new CloneNotSupportedException(getClass().getTypeName());
    }

    @AvailableSince(value = "0.1-build.2")
    @Internal()
    @NonExtendable()
    @NonBlocking()
    @Contract()
    @Deprecated(since = "0.1-build.2", forRemoval = true)
    @Override()
    @SuppressWarnings(value = {"removal"})
    protected void finalize() throws Throwable {

        super.finalize();
    }
}
