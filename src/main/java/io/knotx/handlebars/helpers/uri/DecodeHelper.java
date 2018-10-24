/*
 * Copyright (C) 2018 Knot.x Project
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
package io.knotx.handlebars.helpers.uri;

import com.github.jknack.handlebars.Options;
import io.knotx.knot.templating.handlebars.CustomHandlebarsHelper;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Decodes given value as in {@see http://docs.oracle.com/javase/7/docs/api/java/net/URLDecoder.html}<br>
 * Usage:
 * <pre>
 *     {{decode_uri value}}
 * </pre>
 */
public class DecodeHelper implements CustomHandlebarsHelper<Object> {
  @Override
  public String getName() {
    return "decode_uri";
  }

  @Override
  public Object apply(Object value, Options options) throws IOException {
    Options.Buffer buffer = options.buffer();
    buffer.append(URLDecoder.decode(String.valueOf(value), StandardCharsets.UTF_8.name()));
    return buffer;
  }
}
