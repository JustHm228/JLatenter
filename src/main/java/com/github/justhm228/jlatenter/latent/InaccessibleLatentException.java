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

import java.io.*;
import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@NonBlocking()
public final class InaccessibleLatentException extends LatentException
		implements Serializable {

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public InaccessibleLatentException(
			@Nullable(value = "Can be null anytime") final String message,
			@Nullable(value = "Can be null anytime") final Throwable cause
	) throws @NotNull(exception = NullPointerException.class) Error {

		super(message, cause);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public InaccessibleLatentException(
			@Nullable(value = "Can be null anytime") final Throwable cause
	) throws @NotNull(exception = NullPointerException.class) Error {

		super(cause);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public InaccessibleLatentException(
			@Nullable(value = "Can be null anytime") final String message
	) throws @NotNull(exception = NullPointerException.class) Error {

		super(message);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public InaccessibleLatentException() throws @NotNull(exception = NullPointerException.class) Error {

		super();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @UnknownNullability(value = "Can be null anytime") String getLocalizedMessage() throws @NotNull(exception = NullPointerException.class) Error {

		return super.getLocalizedMessage();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @UnknownNullability(value = "Can be null anytime") String getMessage() throws @NotNull(exception = NullPointerException.class) Error {

		return super.getMessage();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> this")
	@Override()
	public synchronized @NotNull(exception = NullPointerException.class) InaccessibleLatentException initCause(
			@Nullable(value = "Can be null anytime") final Throwable cause
	) throws @NotNull(exception = NullPointerException.class) Error {

		super.initCause(cause);
		return this;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public synchronized @UnknownNullability(value = "Can be null anytime") Throwable getCause() throws @NotNull(exception = NullPointerException.class) Error {

		return super.getCause();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Override()
	public void setStackTrace(
			@NotNull(exception = NullPointerException.class) final StackTraceElement @NotNull(exception = NullPointerException.class) [] stacktrace
	) throws @NotNull(exception = NullPointerException.class) Error, @NotNull(exception = NullPointerException.class) NullPointerException {

		super.setStackTrace(stacktrace);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> this")
	@Override()
	public synchronized @NotNull(exception = NullPointerException.class) InaccessibleLatentException fillInStackTrace() throws @NotNull(exception = NullPointerException.class) Error {

		super.fillInStackTrace();
		return this;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) StackTraceElement @NotNull(exception = NullPointerException.class) [] getStackTrace() throws @NotNull(exception = NullPointerException.class) Error {

		return super.getStackTrace();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Override()
	public void printStackTrace(
			@NotNull(exception = NullPointerException.class) final PrintStream out
	) throws @NotNull(exception = NullPointerException.class) Error, @NotNull(exception = NullPointerException.class) NullPointerException {

		super.printStackTrace(out);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Override()
	public void printStackTrace(
			@NotNull(exception = NullPointerException.class) final PrintWriter out
	) throws @NotNull(exception = NullPointerException.class) Error, @NotNull(exception = NullPointerException.class) NullPointerException {

		super.printStackTrace(out);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Override()
	public void printStackTrace() throws @NotNull(exception = NullPointerException.class) Error, @NotNull(exception = NullPointerException.class) NullPointerException {

		super.printStackTrace();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws @NotNull(exception = NullPointerException.class) Error {

		return super.toString();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(
			@Nullable(value = "Can be null anytime") final Object another
	) throws @NotNull(exception = NullPointerException.class) Error {

		return super.equals(another);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws @NotNull(exception = NullPointerException.class) Error {

		return super.hashCode();
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Deprecated(since = "0.1-build.1", forRemoval = true)
	@Override()
	@SuppressWarnings(value = { "removal" })
	protected void finalize() throws @NotNull(exception = NullPointerException.class) Throwable {

		super.finalize();
	}
}
