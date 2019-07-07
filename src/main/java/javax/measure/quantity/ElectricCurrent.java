/*
 * Units of Measurement API
 * Copyright (c) 2014-2019, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
 * Amount of electric charge flowing past a specified circuit point per unit time. The metric system unit for this quantity is "A" (Ampere).
 *
 * The ampere, symbol A, is the SI unit of electric current. It is defined by taking the
 * fixed numerical value of the elementary charge e to be 1.602 176 634 × 10⁻¹⁹ when
 * expressed in the unit C, which is equal to A s, where the second is defined in terms
 * of ∆νCs.
 *
 * This definition implies the exact relation e = 1.602 176 634 × 10⁻¹⁹ A s. Inverting this
 * relation gives an exact expression for the unit ampere in terms of the defining constants e
 * and ∆νCs:
 *
 * 1 A = (e / 1.602 176 634 × 10⁻¹⁹) s⁻¹
 * <br><br>
 * <b>apiNote:</b> SI Base Unit
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Thodoris Bais</a>
 * @version 2.0
 * @since 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Electric_current">Wikipedia: Electric Current</a>
 * @see ElectricCharge
 * @see Time
 */
public interface ElectricCurrent extends Quantity<ElectricCurrent> {
}
