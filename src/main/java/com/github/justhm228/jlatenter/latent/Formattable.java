package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonBlocking()
public sealed interface Formattable<T extends Formattable<T>> permits Formattable.SelfPrintable, Formattable.XPrintable, Formattable.SelfPrintableLN, Formattable.XPrintableLN, Formattable.SelfFormattable, Formattable.SelfFormatted, Formattable.SelfPrintableF, Formattable.XFormattable, Formattable.XPrintableF {

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) SelfPrintable> print() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) XPrintable> print(final Object ignored) throws Error {

		return XPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) SelfPrintable> println() throws Error {

		return SelfPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) XPrintable> println(final Object ignored) throws Error {

		return XPrintable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) SelfFormattable> format(final Object... ignored) throws Error {

		return SelfFormattable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) SelfFormatted> formatted(final Object... ignored) throws Error {

		return SelfFormatted.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) SelfPrintableF> printf(final Object... ignored) throws Error {

		return SelfPrintableF.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) XFormattable> format(final Object sequence, final Object... ignored) throws Error {

		return XFormattable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<@NotNull(exception = NullPointerException.class) XPrintableF> printf(final Object sequence, final Object... ignored) throws Error {

		return XPrintableF.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintable extends Formattable<SelfPrintable> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract()
		@Shadow()
		void print() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintable extends Formattable<XPrintable> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract()
		@Shadow()
		void print(final Object sequence) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintableLN extends Formattable<SelfPrintableLN> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract()
		@Shadow()
		void println() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XPrintableLN extends Formattable<XPrintableLN> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract()
		@Shadow()
		void println(final Object sequence) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfFormattable extends Formattable<SelfFormattable> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract()
		@Shadow()
		void format(final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfFormatted extends Formattable<SelfFormatted> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract(value = "_ -> _", pure = true)
		@Shadow()
		String formatted(final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfPrintableF extends Formattable<SelfPrintableF> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
		@Contract()
		@Shadow()
		void printf(final Object... args) throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XFormattable extends Formattable<XFormattable> {

		@AvailableSince(value = "0.1-build.1")
		@NonBlocking()
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
		@NonBlocking()
		@Contract()
		@Shadow()
		void printf(final Object sequence, final Object... args) throws Error, LatentException;
	}
}
