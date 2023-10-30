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

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince("0.1-build.1")
@NonExtendable()
@Deprecated(since = "0.1-build.2")
@SuppressWarnings({ "suppress", "warningToken" })
public sealed interface Formattable<T extends Formattable<T>>
		permits com.github.justhm228.jlatenter.latent.stub.Formattable, Formattable.SelfPrintable,
		        Formattable.XPrintable, Formattable.SelfPrintableLN, Formattable.XPrintableLN,
		        Formattable.SelfFormattable, Formattable.SelfFormatted, Formattable.SelfPrintableF,
		        Formattable.XFormattable, Formattable.XPrintableF {

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfPrintable> print() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<XPrintable> print(final Object ignored) throws Error {

		return XPrintable.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfPrintable> println() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<XPrintable> println(
			@Nullable("Can be null anytime") final Object ignored
	                                                                                 ) throws Error {

		return XPrintable.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfFormattable> format(
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                                                                                     ) throws Error {

		return SelfFormattable.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfFormatted> formatted(
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                                                                                      ) throws Error {

		return SelfFormatted.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfPrintableF> printf(
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                                                                                    ) throws Error {

		return SelfPrintableF.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<XFormattable> format(
			@Nullable("Can be null anytime") final Object sequence,
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                                                                                  ) throws Error {

		return XFormattable.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<XPrintableF> printf(
			final Object sequence, final Object @Nullable(
			"Can be null anytime"
	) ... ignored
	                                                                                 ) throws Error {

		return XPrintableF.class;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintable extends Formattable<SelfPrintable> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void print() throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintable extends Formattable<XPrintable> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void print(final Object sequence) throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintableLN extends Formattable<SelfPrintableLN> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void println() throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintableLN extends Formattable<XPrintableLN> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void println(final Object sequence) throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfFormattable extends Formattable<SelfFormattable> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void format(final Object... args) throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfFormatted extends Formattable<SelfFormatted> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = "_ -> _", pure = true)
		@Shadow()
		@SuppressWarnings("unused")
		String formatted(final Object... args) throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintableF extends Formattable<SelfPrintableF> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void printf(final Object... args) throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XFormattable extends Formattable<XFormattable> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void format(final Object sequence, final Object... args) throws Error, LatentException;
	}

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintableF extends Formattable<XPrintableF> {

		@AvailableSince("0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void printf(final Object sequence, final Object... args) throws Error, LatentException;
	}
}
