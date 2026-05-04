
{{#include layout.html.tpl }}

<form action="/contacts" method="get" class="tool-bar"> <3>
    <label for="search">Search Term</label>
    <input id="search" type="search" name="q"
        value="{{ query }}" /> <4>
    <input type="submit" value="Search"/>
</form>