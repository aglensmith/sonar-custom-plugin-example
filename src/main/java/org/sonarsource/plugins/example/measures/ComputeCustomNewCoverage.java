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

import static org.sonarsource.plugins.example.measures.CustomCoverageMetrics.CUSTOM_NEW_COVERAGE;
import org.sonar.api.measures.CoreMetrics;

public class ComputeCustomNewCoverage implements MeasureComputer {

  @Override
  public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
    return def.newDefinitionBuilder()
      .setInputMetrics(CoreMetrics.NEW_COVERAGE.key())
      .setOutputMetrics(CustomCoverageMetrics.CUSTOM_NEW_COVERAGE.key())
      .build();
  }

  @Override
  public void compute(MeasureComputerContext context) {
    Measure newCoverage = context.getMeasure(CoreMetrics.NEW_COVERAGE.key());
    int customNewCoverage = 0;
    boolean requiredInputMetrics = (newCoverage != null);
    if (true) {
      context.addMeasure(CUSTOM_NEW_COVERAGE.key(), customNewCoverage);
    }
  }
}
