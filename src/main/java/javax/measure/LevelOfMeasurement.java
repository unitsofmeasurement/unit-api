/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure;

/**
 * Level of measurement is a classification that describes the nature of information within the values assigned to variables.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Level_of_measurement#Stevens's_typology">Wikipedia: Level of measurement - Stevens's typology</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2, 2018-11-03
 * @since 2.0
 */
public enum LevelOfMeasurement {
    
    /** Classification, membership */
    NOMINAL(false),
    /** Comparison, level */
    ORDINAL(true),
    /** Difference, affinity */
    INTERVAL(true),
    /** Magnitude, amount. The ratio type takes its name from the fact that measurement is the estimation of the ratio between a magnitude of a continuous quantity and a unit magnitude of the same kind (Michell, 1997, 1999).  */
    RATIO(true);
    
    private final boolean quantitative;
    
    private LevelOfMeasurement(boolean quant) {
        this.quantitative = quant;
    }
      
    /**
     * Indicates, if this is a quantitative {@link LevelOfMeasurement}.
     * @return {@code true} for a quantitative {@link LevelOfMeasurement} 
     * @see <a href="https://en.wikipedia.org/wiki/Quantitative">Wikipedia: Quantitative</a> 
     */
    public boolean isQuantitative() {
        return quantitative;
    }
        
    /**
     * Compares two {@link LevelOfMeasurement levelsOfMeasurement} by its ordinal() value.
     *
     * @param other
     *          the other {@link LevelOfMeasurement} to be compared with.
     * @return {@code true} if {@code this >= other}.
     */
    public boolean isGreaterThanOrEqualTo(LevelOfMeasurement other) {
        int myLevel = ordinal();
        int otherLevel = other.ordinal();
        return (myLevel >= otherLevel);
    }
}
