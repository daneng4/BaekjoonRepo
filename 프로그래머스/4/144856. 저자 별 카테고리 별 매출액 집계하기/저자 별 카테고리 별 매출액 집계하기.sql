-- 코드를 입력하세요
SELECT author.author_id, author_name, category, 
    sum(price * sales) as total_sales

from book_sales sales join book on sales.book_id = book.book_id
join author on author.author_id = book.author_id

where year(sales.sales_date) = '2022' and month(sales.sales_date) = '1'
group by category, author_id
order by author_id, category desc