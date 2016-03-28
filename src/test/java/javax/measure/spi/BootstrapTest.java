/*
 * Units of Measurement API
 * Copyright (c) 2014-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.measure.spi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.measure.spi.Bootstrap;
import javax.measure.spi.DefaultServiceProvider;
import javax.measure.spi.ServiceProvider;

import org.junit.Test;

/**
 * Tests for {@link Bootstrap}.
 */
@SuppressWarnings("unchecked")
public class BootstrapTest {

  @Test
  public void testInit() throws Exception {
    Collection<Object> services = Collection.class.cast(Bootstrap.getServices(String.class));
    assertNotNull(services);
    assertFalse(services.isEmpty());
    assertTrue(services.contains("service1"));
    assertTrue(services.contains("service2"));
    services = Collection.class.cast(Bootstrap.getServices(Runtime.class));
    assertNotNull(services);
    assertTrue(services.isEmpty());
  }

  @Test(expected = NullPointerException.class)
  public void testInit_Null() throws Exception {
    ServiceProvider prov = Bootstrap.init(null);
    assertNull(prov);
  }

  @Test
  // (expected = NullPointerException.class)
  public void testInit_InitTwice() throws Exception {
    TestServiceProvider testProv = new TestServiceProvider();
    ServiceProvider prov = Bootstrap.init(testProv);
    assertTrue(testProv == Bootstrap.init(prov));
    assertEquals(0, testProv.getPriority());
  }

  @Test
  public void testGetServiceProvider() throws Exception {
    ServiceProvider prov = Bootstrap.getServiceProvider();
    assertNotNull(prov);
    assertEquals(prov.getClass(), TestServiceProvider.class);
    assertEquals(0, prov.getPriority());
  }

  @Test
  public void testGetServices() throws Exception {
    Collection<Object> services = Collection.class.cast(Bootstrap.getServices(String.class));
    assertNotNull(services);
    assertFalse(services.isEmpty());
    assertTrue(services.contains("service1"));
    assertTrue(services.contains("service2"));
    services = Collection.class.cast(Bootstrap.getServices(Runtime.class));
    assertNotNull(services);
    assertTrue(services.isEmpty());
  }

  @Test
  public void testGetService() throws Exception {
    Integer num = Bootstrap.getService(Integer.class);
    assertNotNull(num);
    assertTrue(num.equals(5));
  }

  @Test
  public void testGetService_BadCase() throws Exception {
    assertNull(Bootstrap.getService(Collection.class));
  }

  public final static class TestServiceProvider extends DefaultServiceProvider implements ServiceProvider {

    @Override
    public <T> List<T> getServices(Class<T> serviceType) {
      if (String.class.equals(serviceType)) {
        return List.class.cast(Arrays.asList("service1", "service2"));
      } else if (Integer.class.equals(serviceType)) {
        return List.class.cast(Arrays.asList(5));
      } else if (Long.class.equals(serviceType)) {
        return List.class.cast(Arrays.asList((long) 111));
      }
      return super.getServices(serviceType);
    }

  }
}
