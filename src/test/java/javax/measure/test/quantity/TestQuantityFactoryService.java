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
package javax.measure.test.quantity;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Quantity;
import javax.measure.spi.QuantityFactory;
import javax.measure.spi.QuantityFactoryService;

/**
 * Provider of Quantity Services
 * 
 * @author Werner Keil
 * @version 0.4
 */
@SuppressWarnings("rawtypes")
public final class TestQuantityFactoryService implements QuantityFactoryService {
  private final Map<Class, QuantityFactory> INSTANCE = new HashMap<Class, QuantityFactory>();

  /**
   * Return a factory for this quantity
   * 
   * @param quantity
   *          the quantity type
   * @return the {@link QuantityFactory}
   * @throws NullPointerException
   */
  @SuppressWarnings("unchecked")
  public final <Q extends Quantity<Q>> QuantityFactory<Q> getQuantityFactory(Class<Q> quantity) {
    if (quantity == null)
      throw new NullPointerException();
    if (!INSTANCE.containsKey(quantity)) {
      synchronized (INSTANCE) {
        INSTANCE.put(quantity, TestQuantityFactory.getInstance(quantity));
      }
    }
    return INSTANCE.get(quantity);
  }
}
