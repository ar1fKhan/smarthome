/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.magic.binding.internal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.magic.binding.MagicBindingConstants;
import org.eclipse.smarthome.magic.binding.handler.MagicColorLightHandler;
import org.eclipse.smarthome.magic.binding.handler.MagicDimmableLightHandler;
import org.eclipse.smarthome.magic.binding.handler.MagicOnOffLightHandler;
import org.eclipse.smarthome.magic.binding.internal.MagicHandlerFactory;
import org.junit.Before;
import org.junit.Test;

public class MagicHandlerFactoryTest {

    private MagicHandlerFactory factory;

    @Before
    public void setup() {
        factory = new MagicHandlerFactory();
    }

    @Test
    public void shoudlReturnNullForUnknownThingTypeUID() {
        Thing thing = mock(Thing.class);
        when(thing.getThingTypeUID()).thenReturn(new ThingTypeUID("anyBinding:someThingType"));

        assertThat(factory.createHandler(thing), is(nullValue()));
    }

    @Test
    public void shoudlReturnColorLightHandler() {
        Thing thing = mock(Thing.class);
        when(thing.getThingTypeUID()).thenReturn(MagicBindingConstants.THING_TYPE_COLOR_LIGHT);

        assertThat(factory.createHandler(thing), is(instanceOf(MagicColorLightHandler.class)));
    }

    @Test
    public void shoudlReturnDimmableLightHandler() {
        Thing thing = mock(Thing.class);
        when(thing.getThingTypeUID()).thenReturn(MagicBindingConstants.THING_TYPE_DIMMABLE_LIGHT);

        assertThat(factory.createHandler(thing), is(instanceOf(MagicDimmableLightHandler.class)));
    }

    @Test
    public void shoudlReturnOnOffLightHandler() {
        Thing thing = mock(Thing.class);
        when(thing.getThingTypeUID()).thenReturn(MagicBindingConstants.THING_TYPE_ON_OFF_LIGHT);

        assertThat(factory.createHandler(thing), is(instanceOf(MagicOnOffLightHandler.class)));
    }
}
