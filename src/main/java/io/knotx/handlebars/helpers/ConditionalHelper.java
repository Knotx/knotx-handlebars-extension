/*
 * Copyright (C) 2016 Knot.x Project
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
package io.knotx.handlebars.helpers;

import com.github.jknack.handlebars.Options;
import io.knotx.te.handlebars.CustomHandlebarsHelper;

import java.io.IOException;

public abstract class ConditionalHelper implements CustomHandlebarsHelper<Object> {

  @Override
  public CharSequence apply(Object firstParam, Options options) throws IOException {

    Options.Buffer buffer = options.buffer();
    if (checkCondition(firstParam, options)) {
      buffer.append(options.fn());
    } else {
      buffer.append(options.inverse());
    }
    return buffer;
  }

  protected abstract Boolean checkCondition(Object firstParam, Options options);
}
