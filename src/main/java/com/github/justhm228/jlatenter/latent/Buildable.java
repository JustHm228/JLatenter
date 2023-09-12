package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
public sealed interface Buildable<T extends Buildable<T>> permits Buildable.XBuildable, Buildable.SelfBuildable, Buildable.GenericBuildable, Buildable.SelfBuildableC, Buildable.GenericBuildableC {

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<XBuildable> buildX() throws Error {

		return XBuildable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<SelfBuildable> buildSelf() throws Error {

		return SelfBuildable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<GenericBuildable> buildGeneric() throws Error {

		return GenericBuildable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<SelfBuildableC> buildSelfC() throws Error {

		return SelfBuildableC.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	static @NotNull(exception = NullPointerException.class) Class<GenericBuildableC> buildGenericC() throws Error {

		return GenericBuildableC.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XBuildable extends Buildable<XBuildable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		void build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfBuildable extends Buildable<SelfBuildable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> this")
		@Shadow()
		Object build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface GenericBuildable extends Buildable<GenericBuildable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> this")
		@Shadow()
		<T> T build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfBuildableC extends Buildable<SelfBuildableC> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> _", pure = true)
		@Shadow()
		Object build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface GenericBuildableC extends Buildable<GenericBuildableC> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> _", pure = true)
		@Shadow()
		<T> T build() throws Error, LatentException;
	}
}
