angular.module('libraryApp')
    .filter('booksFilterTitle', function () {
        return function (booksList, bookFilterModel) {
            var filtered = [];
            var bookTitleMatch = new RegExp(bookFilterModel.bookTitle, 'i');
            for (var i = 0; i < booksList.length; i++) {
                var book = booksList[i];
                if (bookTitleMatch.test(book.title)) {
                    filtered.push(book);
                }
            }
            return filtered;
        };
    });

