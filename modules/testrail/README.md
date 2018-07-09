# RCPTT Integration with TestRail

**TestRail configuration parameters**:
* **host** --- TestRail Host. Should be valid URL and end with slash "/".
* **username** --- Username.
* **password** --- Password or API Key.
* **projectId** --- Project ID. Should start with "P" and end with positive number.

**Examples**
For RCPTT Test Runner:

        -testEngine 'testrail:host=https://example.testrail.net/;username=username@example.com;password=1234567890;projectId=P1'


For RCPTT Maven Plugin:

        <configuration>
          <testEngines>
            <testEngine>
              <id>testrail</id>
              <parameters>
                <host>https://example.testrail.net/</host>
                <username>username@example.com</username>
                <password>1234567890</password>
                <projectId>P1</projectId>
              </parameters>
            </testEngine>
          </testEngines>
        </configuration>


