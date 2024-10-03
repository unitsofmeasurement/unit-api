/*
 * Units of Measurement API
 * Copyright (c) 2014-2024, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
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
package javax.measure.quantity;

import javax.measure.Quantity;

/**
 * Extent of something along its greatest dimension or the extent of space between two objects or places.
 * The metric system unit for this quantity is "m" (metre).
 *
 * The metre, symbol m, is the SI unit of length. It is defined by taking the fixed
 * numerical value of the speed of light in vacuum c to be 299 792 458 when expressed
 * in the unit m s⁻¹, where the second is defined in terms of the caesium frequency
 * ∆νCs.
 *
 * This definition implies the exact relation c = 299 792 458 m s⁻¹. Inverting this relation
 * gives an exact expression for the metre in terms of the defining constants c and ∆νCs:
 *
 * 1 m = (c / 299 792 458)s = 9 192 631 770 c / 299 792 458 ∆νCs ≈ 30.663 319 c / ∆νCs
 * <br>
 * <dl>
 * <dt><span class="strong">API Note:</span></dt><dd>SI Base Unit</dd>
 * </dl>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Thodoris Bais</a>
 * @version 2.1
 * @since 1.0
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Length">Wikipedia: Length</a>
 * @see Area
 * @see Volume
 * @see Angle
 * @see SolidAngle
 * @see Speed
 */
public interface Length extends Quantity<Length> {
}
