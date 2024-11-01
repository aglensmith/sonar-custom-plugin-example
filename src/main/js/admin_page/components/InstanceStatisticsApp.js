/*
 * Copyright (C) 2009-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
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


import React from "react";
import {
  getAuditLogs
} from "../../common/api";

import {Table, Table, TableRowInteractive} from '../../design-system/sonar-aligned/components/Table'

export default class InstanceStatisticsApp extends React.PureComponent {
  state = {
    loading: true,
    auditLogs: []
  };

  componentDidMount() {
    Promise.all([
      getAuditLogs()

    ]).then(([auditLogs]) => {
      this.setState({
        auditLogs
      });
    });
  }

  render() {
    if (this.state.loading) {
      return (
        <div className="page page-limited">
          Loading...
        </div>
      );
    }

    return (
      <div className="page page-limited sanity-check">
        <table className="data zebra">
          <tbody>
            <tr>
              <td className="code-name-cell">
                {window.tp(
                  "test",
                  this.state.auditLogs.length,
                  "test"
                )}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}
