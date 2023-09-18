/*
 * Copyright (c) 2023 JustHuman228
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.justhm228.jlatenter.base;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;
import static java.util.Objects.*;

/**
 * Contains version information and other constants.
 *
 * <p>
 *     Currently it contains such constants:
 *     <ul>
 *         <li><code>{@link #AUTHOR AUTHOR}</code> - an author/provider/{@link Package#getSpecificationVendor() vendor} of the implementation</li>
 *         <li><code>{@link #URL URL}</code> - a link to the project repository</li>
 *         <li><code>{@link #NAME NAME}</code> - a string display name/title of the implementation</li>
 *         <li><code>{@link #INTERNAL_NAME INTERNAL_NAME}</code> - an internal name of the implementation</li>
 *         <li><code>{@link #DESCRIPTION DESCRIPTION}</code> - a short {@link String string} description of the implementation</li>
 *         <li><code>{@link #VERSION VERSION}</code> - a {@link String string} version name of the used implementation</li>
 *         <li><code>{@link #VERSION_CODE VERSION_CODE}</code> - an integer version identifier of the used implementation</li>
 *     </ul>
 * </p>
 *
 * @apiNote _
 * @implSpec _
 * @implNote _
 *
 * @author JustHuman228
 * @since 0.1-build.2
 */
@AvailableSince(value = "0.1-build.2")
@NonExtendable()
@NonBlocking()
public final class Library {

    /**
     * An author/provider/{@link Package#getSpecificationVendor() vendor} of the implementation.
     *
     * @apiNote _
     * @implSpec _
     * @implNote _
     *
     * @since 0.1-build.2
     */
    @AvailableSince(value = "0.1-build.2")
    @NotNull(exception = NullPointerException.class)
    @SuppressWarnings(value = { "unused" }) // <-- These constants WILL BE used
    public static final String AUTHOR = requireNonNullElse(Library.class.getPackage().getSpecificationVendor(), "JustHuman228"), // <-- Obtain the author name from `MANIFEST.MF`

                               /**
                                * A link to the project repository.
                                *
                                * @apiNote _
                                * @implSpec _
                                * @implNote _
                                *
                                * @since 0.1-build.2
                                */
                               URL = "https://github.com/JustHm228/JLatenter",

                               /**
                                * A {@link String string} display name/title of the implementation.
                                *
                                * @apiNote _
                                * @implSpec _
                                * @implNote _
                                * @since 0.1-build.2
                                */
                               NAME = requireNonNullElse(Library.class.getPackage().getSpecificationTitle(), "JLatenter"), // <-- Obtain the project name from `MANIFEST.MF`

                               /**
                                * An internal name of the implementation.
                                *
                                * @apiNote _
                                * @implSpec _
                                * @implNote _
                                *
                                * @since 0.1-build.2
                                */
                               INTERNAL_NAME = "jlatenter",

                               /**
                                * A short {@link String string} description of the implementation.
                                *
                                * @apiNote _
                                * @implSpec _
                                * @implNote _
                                *
                                * @since 0.1-build.2
                                */
                               DESCRIPTION = "A small implementation of latent typing in Java which uses dynamic proxies to redirect method calls from a stub interface to the real object",

                               /**
                                * A {@link String string} version name of the used implementation.
                                *
                                * @apiNote Should be used only as a user-visible string.
                                *          To determine which version of the implementation is used you should use <code>{@link #VERSION_CODE VERSION_CODE}</code>.
                                * @implSpec _
                                * @implNote _
                                *
                                * @since 0.1-build.2
                                */
                               VERSION = requireNonNullElse(Library.class.getPackage().getSpecificationVersion(), "0.1-build.2"); // <-- Obtain the project version's display name from `MANIFEST.MF`

    /**
     * An integer version identifier of the used implementation.
     *
     * @apiNote Should be used only to determine which version of the implementation is used.
     *          A user-visible equivalent is <code>{@link #VERSION VERSION}</code>.
     * @implSpec _
     * @implNote _
     *
     * @since 0.1-build.2
     */
    @AvailableSince(value = "0.1-build.2")
    @SuppressWarnings(value = { "unused" }) // This constant WILL BE used
    public static final int VERSION_CODE = 1;

    /**
     * Prevents instantiation of an instance.
     *
     * <p>Yeah, it just throws an {@link UnsupportedOperationException exception}.</p>
     *
     * @deprecated This constructor shouldn't be used to instantiate an {@link Library object} - its main goal is to prevent this!
     *
     * @throws Error If something went wrong in the JVM.
     * @throws UnsupportedOperationException Always.
     *
     * @apiNote _
     * @implSpec _
     * @implNote _
     *
     * @since 0.1-build.2
     */
    @AvailableSince(value = "0.1-build.2")
    @Internal()
    @NonBlocking()
    @Contract(value = " -> fail", pure = true)
    @Deprecated(since = "0.1-build.2")
    private Library() throws Error, UnsupportedOperationException {

        super();
        throw new UnsupportedOperationException("You can't instantiate an instance of this type (" + getClass().getTypeName() + ") with a constructor!"); // Prevent instantiation
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

        return another instanceof Library; // `Library` can't contain any data so if the passed object is an instance of `Library` - it's already equal to the current object
    }

    @AvailableSince(value = "0.1-build.2")
    @NonExtendable()
    @NonBlocking()
    @Contract(value = " -> _", pure = true)
    @Override()
    public int hashCode() throws Error {

        return hash(getClass()); // `Library` can't contain any data, so we'll use hash of the class
    }

    /**
     * Prevents cloning.
     *
     * <p>Yeah, it just throws an {@link CloneNotSupportedException exception}.</p>
     *
     * @return Never returns.
     *
     * @throws Error If something went wrong in the JVM.
     * @throws CloneNotSupportedException Always.
     *
     * @apiNote _
     * @implSpec _
     * @implNote _
     *
     * @since 0.1-build.2
     */
    @AvailableSince(value = "0.1-build.2")
    @Internal()
    @NonExtendable()
    @NonBlocking()
    @Contract(value = " -> fail", pure = true)
    @Deprecated(since = "0.1-build.2")
    @Override()
    protected Library clone() throws Error, CloneNotSupportedException {

        throw new CloneNotSupportedException(getClass().getTypeName()); // Always prevent cloning (even if `Library` will implement `Cloneable`) - no instances should be instantiated!
    }

    // FIXME: 16.09.2023 Remove finalize() - it's marked for removal in the JDK, so its use may lead to compile/runtime errors in the future!
    /**
     * Just finalizes the {@link Library object}.
     *
     * @deprecated <code>{@link Object#finalize() finalize}()</code> is marked for removal in the JDK, so its future use may lead to compile/runtime {@link Error errors} in the newer versions of Java.
     *             It'll be removed in a future version (including all other {@link Override overriding} methods).
     *
     * @throws Throwable If something went wrong while finalization.
     *
     * @apiNote _
     * @implSpec <i>Presence of <code>{@link Object#finalize() finalize}()</code> in <code>{@link Object Object}</code>?</i>
     * @implNote Should be removed in a future version.
     *
     * @since 0.1-build.2
     */
    @AvailableSince(value = "0.1-build.2")
    @Internal()
    @NonExtendable()
    @NonBlocking()
    @Contract()
    @Deprecated(since = "0.1-build.2", forRemoval = true)
    @Override()
    @SuppressWarnings(value = { "removal" })
    protected void finalize() throws Throwable {

        super.finalize();
    }
}
