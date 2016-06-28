/**
 Copyright 2005, 2014 Bytecode Pty Ltd.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
package au.com.bytecode.opencsv;

import java.io.IOException;
import java.util.Iterator;

public class CSVIterator implements Iterator<String[]> {
    private CSVReader reader;
    private String[] nextLine;

    public CSVIterator(CSVReader reader) throws IOException {
        this.reader = reader;
        nextLine = reader.readNext();
    }

    public boolean hasNext() {
        return nextLine != null;
    }

    public String[] next() {
        String[] temp = nextLine;
        try {
            nextLine = reader.readNext();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    public void remove() {
        throw new UnsupportedOperationException("This is a read only iterator.");
    }
}
