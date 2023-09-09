package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonBlocking()
@FunctionalInterface()
@Shadow()
public interface Gettable {

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Shadow()
	Object get() throws Error, LatentException; // TODO: 09.09.2023 Expand.
}
