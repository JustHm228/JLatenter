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

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
public sealed interface Formattable<T extends Formattable<T>>
		permits Formattable.SelfPrintable, Formattable.XPrintable, Formattable.SelfPrintableLN,
		        Formattable.XPrintableLN, Formattable.SelfFormattable, Formattable.SelfFormatted,
		        Formattable.SelfPrintableF, Formattable.XFormattable, Formattable.XPrintableF {

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfPrintable> print() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XPrintable> print(final Object ignored) throws Error {

		return XPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfPrintable> println() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XPrintable> println(
			@Nullable(value = "Can be null anytime") final Object ignored
	                     ) throws Error {

		return XPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfFormattable> format(
			@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") ... ignored
	                         ) throws Error {

		return SelfFormattable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfFormatted> formatted(
			@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") ... ignored
	                          ) throws Error {

		return SelfFormatted.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfPrintableF> printf(
			@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") ... ignored
	                        ) throws Error {

		return SelfPrintableF.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XFormattable> format(
			@Nullable(value = "Can be null anytime") final Object sequence,
			@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") ... ignored
	                      ) throws Error {

		return XFormattable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XPrintableF> printf(
			@Nullable(value = "Can be null anytime") final Object sequence,
			@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") ... ignored
	                     ) throws Error {

		return XPrintableF.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintable extends Formattable<SelfPrintable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void print() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintable extends Formattable<XPrintable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void print(final Object sequence) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintableLN extends Formattable<SelfPrintableLN> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void println() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintableLN extends Formattable<XPrintableLN> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void println(final Object sequence) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfFormattable extends Formattable<SelfFormattable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void format(final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfFormatted extends Formattable<SelfFormatted> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = "_ -> _", pure = true)
		@Shadow()
		String formatted(final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintableF extends Formattable<SelfPrintableF> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void printf(final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XFormattable extends Formattable<XFormattable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void format(final Object sequence, final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintableF extends Formattable<XPrintableF> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void printf(final Object sequence, final Object... args) throws Error, LatentException;
	}
}
