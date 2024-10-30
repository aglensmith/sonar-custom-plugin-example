/*
 * Example Plugin for SonarQube
 * Copyright (C) 2009-2020 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarsource.plugins.example.measures;

import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;

import static org.sonarsource.plugins.example.measures.CustomCoverageMetrics.CUSTOM_TEST_SUCCESS;
import org.sonar.api.measures.CoreMetrics;

public class ComputeCustomTestSuccess implements MeasureComputer {

  @Override
  public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
    return def.newDefinitionBuilder()
      .setInputMetrics(
        CoreMetrics.TESTS.key(), 
        CoreMetrics.TEST_ERRORS.key(), 
        CoreMetrics.TEST_FAILURES.key()
      )
      .setOutputMetrics(CustomCoverageMetrics.CUSTOM_TEST_SUCCESS.key())
      .build();
  }

  @Override
  public void compute(MeasureComputerContext context) {
    /* default custom test success density to 0*/
    double customTestSuccessDensity = 0;
    Measure tests = context.getMeasure(CoreMetrics.TESTS.key());
    Measure testErrors = context.getMeasure(CoreMetrics.TEST_ERRORS.key());
    Measure testFailures = context.getMeasure(CoreMetrics.TEST_FAILURES.key());
    boolean weHaveNecessaryMeasures = (tests != null && testErrors != null && testFailures != null);
    
    if (weHaveNecessaryMeasures) {
      /* if we have the required measures... */
      int numTests = tests.getIntValue();
      int numErrors = testErrors.getIntValue();
      int numFailures = testFailures.getIntValue();
      
      /* ...calculate custom test success density */
      customTestSuccessDensity = ((((double)numTests-numErrors-numFailures)/(numTests))*100);
    }

    /* always add custom test success density measure */
    context.addMeasure(CUSTOM_TEST_SUCCESS.key(), customTestSuccessDensity);
  }
}
