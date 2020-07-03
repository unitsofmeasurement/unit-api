/*
 * Units of Measurement API
 * Copyright (c) 2014-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
 * Measure of the quantity of matter that a body or an object contains. The mass of the body is not dependent on gravity and therefore is different
 * from but proportional to its weight. The metric system unit for this quantity is "kg" (kilogram).
 *
 * The kilogram, symbol kg, is the SI unit of mass. It is defined by taking the fixed
 * numerical value of the Planck constant h to be 6.626 070 15 × 10⁻³⁴ when expressed
 * in the unit J s, which is equal to kg m² s−1, where the metre and the second are
 * defined in terms of c and ∆νCs.
 *
 * This definition implies the exact relation h = 6.626 070 15 × 10−34 kg m² s⁻¹. Inverting this
 * relation gives an exact expression for the kilogram in terms of the three defining constants
 * h, ∆νCs and c:
 *
 * 1 kg = (h / 6.626 070 15 × 10⁻³⁴) m⁻² s
 * <br>
 * <dl>
 * <dt><span class="strong">API Note:</span></dt><dd>SI Base Unit</dd>
 * </dl>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Thodoris Bais</a>
 * @version 2.0
 * @since 1.0
 *
 * @see <a href="https://en.wikipedia.org/wiki/Mass">Wikipedia: Mass</a>
 * @see RadiationDoseAbsorbed
 */
public interface Mass extends Quantity<Mass> {
}
