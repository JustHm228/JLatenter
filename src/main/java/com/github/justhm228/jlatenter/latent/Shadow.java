package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@NonBlocking()
@Target(value = { TYPE, METHOD })
@Retention(value = CLASS)
@Documented()
public @interface Shadow {

}
