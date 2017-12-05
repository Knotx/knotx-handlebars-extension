# knotx-handlebars-extension
Custom Knot.x Handlebars Helpers

To build run:
* `mvn clean package`

To use extensions simply add `knotx-handlebars-extension-x.y.z.jar` to classpath together with Knot.x instance.

## Helpers

### ElementHelper
Get the n-th element from a json array.

**Usage**
```
{{element array n}}
```

**Example**
```
{
  locales: ["en_us", "pl_pl", "en_uk"]
}
```
```
{{element locales 2}} // "en_uk"

```

### Conditions checks
#### AND
...

### Math helpers
#### GreaterEqualHelper
Checks if value1 is greater or equal to value2.
**Usage**
```
{{#ge value1 value2}}
  greater or equal
{{else}}
  less
{{/ge}}
```
**Examples**
```
{
  "someIntA": 1,
  "someIntB": 5,
  "someDoubleA": 5.14,
  "someDoubleB": 3.14
}
```
```
{{#ge someIntA someIntB}}
  greater or equal
{{else}}
  less
{{/ge}}
```
Output: `less`
```
{{#ge someDoubleA someDoubleB}}
  greater or equal
{{else}}
  less
{{/ge}}
```
Output: `greater or equal`

### Uri helpers
...