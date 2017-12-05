/*
 * Copyright (C) 2016 Cognifide Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.knotx.handlebars.helpers.math;

import com.github.jknack.handlebars.Options;
import io.knotx.knot.templating.handlebars.CustomHandlebarsHelper;
import java.io.IOException;

/**
 * Checks if value1 is smaller than value2.<br> Usage:
 * <pre>
 *     {{#lt value1 value2}}
 *          smaller
 *     {{else}}
 *         greater or equal
 *     {{/lt}}
 * </pre>
 */
public class LessThanHelper<T extends Number & Comparable<T>> implements CustomHandlebarsHelper<T> {

  @Override
  public String getName() {
    return "lt";
  }

  @Override
  public Object apply(T firstParam, Options options) throws IOException {
    T secondParam = options.param(0);
    return firstParam.compareTo(secondParam) < 0 ? options.fn() : options.inverse();
  }
}
