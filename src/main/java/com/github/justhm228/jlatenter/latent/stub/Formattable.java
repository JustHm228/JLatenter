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

package com.github.justhm228.jlatenter.latent.stub;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince("0.1-build.2")
@NonExtendable()
@SuppressWarnings({ "suppress", "warningToken", "deprecation" })
public non-sealed interface Formattable<T extends Formattable<T>>
		extends com.github.justhm228.jlatenter.latent.Formattable<T> {

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfPrintable> print() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XPrintable> print(final Object ignored) throws Error {

		return XPrintable.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfPrintable> println() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XPrintable> println(@Nullable("Can be null anytime") final Object ignored) throws Error {

		return XPrintable.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfFormattable> format(
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                         ) throws Error {

		return SelfFormattable.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfFormatted> formatted(
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                          ) throws Error {

		return SelfFormatted.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) SelfPrintableF> printf(@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored)
			throws Error {

		return SelfPrintableF.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XFormattable> format(
			@Nullable("Can be null anytime") final Object sequence,
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                      ) throws Error {

		return XFormattable.class;
	}

	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(
			exception = NullPointerException.class
	) XPrintableF> printf(
			@Nullable("Can be null anytime") final Object sequence,
			@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... ignored
	                     ) throws Error {

		return XPrintableF.class;
	}
}
