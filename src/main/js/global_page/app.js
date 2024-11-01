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
let el, stylesTag;

function init() {
  // sample code for inner SonarQube page
  el.innerHTML = `
<div class="page page-limited example-global_page">
  <p><a href="https://sonarsource.com" target="_blank">My Custom Link 1</a></p>
  <p><a href="https://google.com" target="_blank">My Custom Link 2</a></p>
</div>
`;
}

export function start(element) {
  // this code will launch the link directly from the click in the menu
  window.open('https://sonarsource.com');
  window.history.back(); // to avoid this opening a dummy empty page, go back to where the user just was

  // uncomment these lines if you want to navigate to a page INSIDE SonarQube containing your links
  //el = element;
  //init();
}

export function stop() {
  // Remove any event listeners we still have.
}
