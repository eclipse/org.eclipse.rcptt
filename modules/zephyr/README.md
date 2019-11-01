# RCPTT Integration with Zephyr

**Zephyr configuration parameters**:
* **host** --- Zephyr Host. Should be valid URL and end with slash "/".
* **username** --- Username.
* **password** --- Password or API Key.
* **projectId** --- Project ID. Should start with "P" and end with positive number.

**Examples**
For RCPTT Test Runner:

        -testEngine 'zephyr:baseUrl=https://example.zephyr.net/;username=username@example.com;password=1234567890;projectId=P1'


For RCPTT Maven Plugin:

        <configuration>
          <testEngines>
            <testEngine>
              <id>zephyr</id>
              <parameters>
                <baseUrl>https://example.zephyr.net/</baseUrl>
                <username>username@example.com</username>
                <password>1234567890</password>
                <project>P1</project>
                <version>v1.0</version>
                <cycle>Add hoc</cycle>
              </parameters>
            </testEngine>
          </testEngines>
        </configuration>


