package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonBlocking()
@FunctionalInterface()
@Shadow()
public interface Renderable {

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract()
	@Shadow()
	void render() throws Error, LatentException;
}
