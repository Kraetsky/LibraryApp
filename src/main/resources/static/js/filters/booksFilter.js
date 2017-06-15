angular.module('libraryApp')
    .filter('booksFilter', function () {
        return function (booksList, bookFilterModel) {
            var filtered = [];
            var bookAuthorMatch = new RegExp(bookFilterModel.bookAuthor, 'i');
            for (var i = 0; i < booksList.length; i++) {
                var book = booksList[i];
                if (bookAuthorMatch.test(book.author)) {
                    filtered.push(book);
                }
            }
            return filtered;
        };
    });
