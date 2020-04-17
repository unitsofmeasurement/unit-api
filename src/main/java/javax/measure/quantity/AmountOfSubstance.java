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
 * Number of elementary entities (molecules, for example) of a substance. The metric system unit for this quantity is "mol" (mole).
 *
 * The mole, symbol mol, is the SI unit of amount of substance. One mole contains
 * exactly 6.022 140 76 × 10²³ elementary entities. This number is the fixed numerical
 * value of the Avogadro constant, NA, when expressed in the unit mol⁻¹ and is called
 * the Avogadro number.
 *
 * The amount of substance, symbol n, of a system is a measure of the number of
 * specified elementary entities. An elementary entity may be an atom, a molecule, an
 * ion, an electron, any other particle or specified group of particles.
 * This definition implies the exact relation Nₐ = 6.022 140 76 × 10²³ mol⁻¹.
 *
 * Inverting this relation gives an exact expression for the mole in terms of the defining constant NA:
 *
 * 1 mol = 6.02214076 × 10²³ / Nₐ
 * <br><br>
 * @apiNote SI Base Unit
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Thodoris Bais</a>
 * @version 2.1
 * @since 1.0
 *
 * @see <a href="http://en.wikipedia.org/wiki/Amount_of_substance">Wikipedia: Amount of Substance</a>
 */
public interface AmountOfSubstance extends Quantity<AmountOfSubstance> {
}
