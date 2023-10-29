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

package com.github.justhm228.jlatenter.latent;

import java.lang.*;
import java.io.*;
import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import static java.util.Objects.*;
import static java.lang.System.*;
import static com.github.justhm228.jlatenter.base.Library.*;

@AvailableSince("0.1-build.1")
@NonExtendable()
@NonBlocking()
@SuppressWarnings({ "suppress", "warningToken" })
public abstract sealed class LatentException extends RuntimeException
		implements Serializable
		permits LatentPermException, LatentNotPresentException,
		        IncompatibleLatentException, InaccessibleLatentException,
		        LatentInitException, LatentTargetException {

	// @AvailableSince("0.1-build.2")
	// @Internal()
	// @Serial()
	// private static final long serialVersionUID = 0L; // TODO: 24.10.2023 Uncomment this later

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	protected LatentException(
			@Nullable("Can be null anytime") final String message,
			@Nullable("Can be null anytime") final Throwable cause
	                         ) throws Error {

		super(message, cause);
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	protected LatentException(
			@Nullable("Can be null anytime") final Throwable cause
	                         ) throws Error {

		super(cause);
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	protected LatentException(
			@Nullable("Can be null anytime") final String message
	                         ) throws Error {

		super(message);
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	protected LatentException() throws Error {

		super();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @UnknownNullability("Can be null anytime") String getLocalizedMessage() throws Error {

		return super.getLocalizedMessage();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @UnknownNullability("Can be null anytime") String getMessage() throws Error {

		return super.getMessage();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract("_ -> this")
	@Override()
	public synchronized @NotNull(exception = NullPointerException.class) LatentException initCause(
			@Nullable("Can be null anytime") final Throwable cause
	                                                                                              ) throws Error {

		super.initCause(cause);
		return this;
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public synchronized @UnknownNullability("Can be null anytime") Throwable getCause() throws Error {

		return super.getCause();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract()
	@Override()
	public void setStackTrace(
			@NotNull(exception = NullPointerException.class) final StackTraceElement @NotNull(
					exception = NullPointerException.class
			) [] stacktrace
	                         ) throws Error, NullPointerException {

		super.setStackTrace(requireNonNull(stacktrace));
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(" -> this")
	@Override()
	public synchronized @NotNull(exception = NullPointerException.class) LatentException fillInStackTrace()
			throws Error {

		super.fillInStackTrace();
		return this;
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) StackTraceElement @NotNull(
			exception = NullPointerException.class
	) [] getStackTrace() throws Error {

		return super.getStackTrace();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Override()
	public void printStackTrace(
			@NotNull(exception = NullPointerException.class) final PrintStream out
	                           ) throws Error, NullPointerException {

		super.printStackTrace(requireNonNull(out));
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Override()
	public void printStackTrace(
			@NotNull(exception = NullPointerException.class) final PrintWriter out
	                           ) throws Error, NullPointerException {

		super.printStackTrace(requireNonNull(out));
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	@SuppressWarnings("CallToPrintStackTrace")
	public void printStackTrace() throws Error, NullPointerException {

		requireNonNull(out);
		super.printStackTrace();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return super.toString();
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(
			@Nullable(value = "Can be null anytime") final Object another
	                     ) throws Error {

		return super.equals(another);
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return super.hashCode();
	}

	@AvailableSince("0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.1")
	@Override()
	@SuppressWarnings({ "super", "CloneDoesntCallSuperClone" })
	protected final LatentException clone() throws Error, CloneNotSupportedException {

		// throw new CloneNotSupportedException(getClass().getTypeName());

		return preventClone();
	}

	@AvailableSince("0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Deprecated(since = "0.1-build.1", forRemoval = true)
	@Override()
	@SuppressWarnings(value = { "removal" })
	protected void finalize() throws Throwable {

		super.finalize();
	}
}
