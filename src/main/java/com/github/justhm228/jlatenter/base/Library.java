/*
 * The MIT License
 *
 * Copyright (c) 2023 Chirkunov Egor
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
import java.util.*;
import java.lang.StackWalker.*;
import static java.util.Optional.*;

/**
 * Contains version information and other constants.
 *
 * <p>
 * Currently it contains such constants:
 * </p>
 *
 * <ul>
 *     <li>
 *         <code>{@link #AUTHOR AUTHOR}</code> -
 *         an author/provider/{@link Package#getSpecificationVendor() vendor}
 *         of the implementation
 *     </li>
 *     <li>
 *         <code>{@link #URL URL}</code> - a link to the project repository
 *     </li>
 *     <li>
 *         <code>{@link #NAME NAME}</code> - a string display name/title of
 *         the implementation
 *     </li>
 *     <li>
 *         <code>{@link #INTERNAL_NAME INTERNAL_NAME}</code> - an internal name of
 *         the implementation
 *     </li>
 *     <li>
 *         <code>{@link #DESCRIPTION DESCRIPTION}</code> -
 *         a short {@link String string} description of the implementation
 *     </li>
 *     <li>
 *         <code>{@link #VERSION VERSION}</code> - a {@link String string} version name of
 *         the used implementation
 *     </li>
 *     <li>
 *         <code>{@link #VERSION_CODE VERSION_CODE}</code> - an integer version identifier of
 *         the used implementation
 *     </li>
 * </ul>
 *
 * @author JustHuman228
 * @since 0.1-build.2
 */
@AvailableSince("0.1-build.2")
@NonExtendable()
@NonBlocking()
@SuppressWarnings({ "suppress", "warningToken" })
public final class Library {

	/**
	 * An author/provider/{@link Package#getSpecificationVendor() vendor} of the implementation.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NotNull(exception = NullPointerException.class)
	@SuppressWarnings("unused") // <-- This constant WILL BE used
	// Obtain the author name from `MANIFEST.MF`:
	public static final String AUTHOR = requireNonNullElse(
			Library.class.getPackage().getSpecificationVendor(),
			"JustHuman228"
	                                                      );

	/**
	 * A link to the project repository.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NotNull(exception = NullPointerException.class)
	@SuppressWarnings("unused") // <-- This constant WILL BE used
	public static String URL = "https://github.com/JustHm228/JLatenter";

	/**
	 * A {@link String string} display name/title of the implementation.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NotNull(exception = NullPointerException.class)
	@SuppressWarnings("unused") // <-- This constant WILL BE used
	// Obtain the project name from `MANIFEST.MF`:
	public static final String NAME = requireNonNullElse(
			Library.class.getPackage().getSpecificationTitle(),
			"JLatenter"
	                                                    );

	/**
	 * An internal name of the implementation.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NotNull(exception = NullPointerException.class)
	@SuppressWarnings("unused") // <-- This constant WILL BE used
	public static final String INTERNAL_NAME = "jlatenter";

	/**
	 * A short {@link String string} description of the implementation.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NotNull(exception = NullPointerException.class)
	@SuppressWarnings("unused") // <-- This constant WILL BE used
	public static final String DESCRIPTION =
			"A small library which allows you to \"interpret\" any object of any type as an object that implements " +
			"an interface you specify";

	/**
	 * A {@link String string} version name of the used implementation.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NotNull(exception = NullPointerException.class)
	@SuppressWarnings("unused") // <-- This constant WILL BE used
	// Obtain the project version's display name from `MANIFEST.MF`:
	public static final String VERSION = requireNonNullElse(
			Library.class.getPackage().getSpecificationVersion(),
			"0.1-build.2"
	                                                       );

	/**
	 * An integer version identifier of the used implementation.
	 *
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@SuppressWarnings("unused") // This constant WILL BE used
	public static final int VERSION_CODE = 1;

	@AvailableSince("0.1-build.2")
	@Internal()
	@Experimental()
	@NotNull(exception = NullPointerException.class)
	public static final String CONST_EMSG_UTILCLASS =
			"An instance of this type (%s) can't be instantiated with a constructor!";

	@AvailableSince("0.1-build.2")
	@Internal()
	@Experimental()
	@NotNull(exception = NullPointerException.class)
	public static final String CONST_EMSG_IMMUTABLE = "%s";

	@AvailableSince("0.1-build.2")
	@Internal()
	@Experimental()
	@NotNull(exception = NullPointerException.class)
	public static final String CONST_EMSG_NULL = "%s is null!";

	@AvailableSince("0.1-build.2")
	@Internal()
	@Experimental()
	@UnknownNullability("Will be null before the first caller search")
	private static volatile StackWalker stack = null;

	/**
	 * Prevents instantiation of an instance.
	 *
	 * <p>Yeah, it just throws an {@link UnsupportedOperationException exception}.</p>
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws UnsupportedOperationException Always.
	 * @since 0.1-build.2
	 * @deprecated This constructor shouldn't be used to instantiate an {@link Library object} - its main goal is to
	 * prevent this!
	 */
	@AvailableSince("0.1-build.2")
	@Internal()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.2")
	private Library() throws Error, UnsupportedOperationException {

		super();

		// throw new UnsupportedOperationException(
		// 		"An instance of this type (" + getClass().getTypeName() + ") with a constructor!"
		// ); // Prevent instantiation

		preventInstantiation(); // Prevent instantiation
	}

	@AvailableSince("0.1-build.2")
	@Internal()
	@Experimental()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	public static void preventInstantiation() throws Error, UnsupportedOperationException {

		@NotNull(exception = NullPointerException.class)
		final Optional<? extends StackFrame> caller = getCaller();

		throw new UnsupportedOperationException(
				CONST_EMSG_UTILCLASS.formatted(caller.isPresent() ? caller.get().getClassName() : "null"));
	}

	@AvailableSince("0.1-build.2")
	@Internal()
	@Experimental()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	public static <T> T preventClone() throws Error, CloneNotSupportedException {

		@NotNull(exception = NullPointerException.class)
		final Optional<? extends StackFrame> caller = getCaller();

		throw new CloneNotSupportedException(
				CONST_EMSG_IMMUTABLE.formatted(caller.isPresent() ? caller.get().getClassName() : "null"));
	}

	@AvailableSince(value = "0.1-build.2")
	@Internal()
	@Experimental()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, null -> fail; _, !null -> param2")
	public static <V> V checkForNull(
			@UnknownNullability("Can be null anytime") final String name, @Nullable("Can be null anytime") final V value
	                                ) throws Error, NullPointerException {

		return name == null ? requireNonNull(value) : requireNonNull(value, CONST_EMSG_NULL.formatted(name));
	}

	@AvailableSince(value = "0.1-build.2")
	@Internal()
	@Experimental()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	private static @NotNull(exception = NullPointerException.class) Optional<? extends StackFrame> getCaller()
			throws Error {

		if (stack == null) {

			stack = StackWalker.getInstance();
		}

		{

			@NotNull(exception = NullPointerException.class)
			final StackWalker stack = Library.stack;

			try {

				return stack.walk((context) -> context.skip(2L).findFirst());

			} catch (@NotNull(exception = NullPointerException.class) final NullPointerException notFound) {

				return empty();
			}
		}
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return super.toString();
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable("Can be null anytime") final Object another) throws Error {

		// `Library` can't contain any data so if the passed object is an instance of `Library` -
		// it's already equal to the current object:
		return another instanceof Library;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		// `Library` can't contain any data, so we'll use hash of the class:
		return hash(getClass());
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
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.2")
	@Override()
	@SuppressWarnings({ "super", "CloneDoesntCallSuperClone" })
	protected Library clone() throws Error, CloneNotSupportedException {

		// // Always prevent cloning (even if `Library` will implement `Cloneable`) -
		// // no instances should be instantiated!
		// throw new CloneNotSupportedException(getClass().getTypeName());

		// Always prevent cloning (even if `Library` will implement `Cloneable`) -
		// no instances should be instantiated!
		return preventClone();
	}
}
